(ns ns-net.server.atom-mapper
  (:require [net-ns.server.mapper :as mapper]
            [net-ns.server.simple-mapper :as sim-mapper])
  (:use [clojure.contrib.core :only (dissoc-in)]))

(extend-type clojure.lang.Atom
  mapper/Mapper
    (register-client
      ([client-map host]
        (swap! client-map sim-mapper/register-client host)
      ([client-map host init-set]
        (swap! client-map sim-mapper/register-client host init-set))))
    
    (register-fn
      [client-map f host]
      (swap! client-map sim-mapper/register-fn f host))
  
    (unregister-client
      [client-map host]
      (swap! client-map sim-mapper/unregister-client host))
  
    (unregister-fn
      [client-map f host]
      (swap! client-map sim-mapper/unregister-fn f host))
  
    (get-fn
      ([client-map f]
        (sim-mapper/get-fn @client-map f))
      ([client-map f host]
        (sim-mapper/get-fn @client-map f host))))

(comment (declare register-client)

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
      ([client-map f host]))) )

