(ns net-ns.server.simple-mapper
  (:require [net-ns.server.mapper :as mapper])
  (:use [clojure.contrib.core :only (dissoc-in)]))

(declare register-client)

(extend-type clojure.lang.PersistentArrayMap
  mapper/Mapper
    (register-client
      ([client-map host]
       (assoc client-map host #{}))
      ([client-map host init-set]
       (if (instance? clojure.lang.PersistentHashSet init-set)
         (assoc client-map host init-set)
         (register-client client-map host))))

    (register-fn
      [client-map f host]
      (let [func-set (client-map host)]
        (if (nil? func-set)
          (register-client client-map host #{f})
          (assoc client-map host (conj (client-map host) f)))))

    (unregister-client
      [client-map host]
      (dissoc client-map host))

    (unregister-fn
      [client-map f host]
      (dissoc-in client-map [host f]))

    (get-fn
      ([client-map f])
      ([client-map f host])))

