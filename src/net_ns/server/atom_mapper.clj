(ns ns-net.server.atom-mapper
  (:require [net-ns.server.mapper :as mapper])
  (:use [clojure.contrib.core :only (dissoc-in)]))

(declare register-client)

(extend-type clojure.lang.Atom
  mapper/Mapper
    (register-client
      ([client-map host]
       (swap! client-map assoc host #{}))
      ([client-map host init-set]
       (if (instance? clojure.lang.PersistentHashSet init-set)
         (swap! client-map assoc host init-set)
         (register-client client-map host))))

    (register-fn
      [client-map f host]
      (let [func-set (client-map host)]
        (if (nil? func-set)
          (register-client client-map host #{f})
          (swap! client-map assoc host (conj (@client-map host) f)))))

    (unregister-client
      [client-map host]
      (swap! client-map dissoc host))

    (unregister-fn
      [client-map f host]
      (swap! client-map dissoc-in [host f]))

    (get-fn
      ([client-map f])
      ([client-map f host])))

