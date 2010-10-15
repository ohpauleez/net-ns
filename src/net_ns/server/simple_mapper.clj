(ns net-ns.server.simple-mapper
  (:require [net-ns.server.mapper :as mapper])
  (:use [clojure.contrib.core :only (dissoc-in)]))

(extend-type clojure.lang.PersistentArrayMap
  mapper/Mapper
    (register-client
      "Register a client as an endpoint, and optionally take
      and initial set of functions.  If init-set is not a 
      clojure.lang.PersistentHashSet, it is ignored.
      Arguments:
        client-map - a map, anything that supports APersistentMap
        host - a string, the hostname of the client
        [init-set] - a set of of strings, the names of functions
      Returns:
        the map with the client added"
      ([client-map host]
       (assoc client-map host #{}))
      ([client-map host init-set]
       (if (isa? (class init-set) clojure.lang.PersistentHashSet)
         (assoc client-map host init-set)
         (register-client client-map host))))

    (register-fn
      "Register a function with a client.  If the client is not
      already in the serve-map, it is added with the function as
      its init-set.
      Arguments:
        client-map - a map, anything that supports APersistentMap
        f - a string, the name of the function to register
        host - a string, the hostname of the client
      Returns:
        the map with the updated function list for the client"
      [client-map f host]
      (let [func-set (serve-map host)]
        (if (nil? func-set)
          (register-client client-map host #{f})
          (assoc client-map host (conj (client-map host) f)))))

    (unregister-client
      ""
      [client-map host]
      (dissoc client-map host))

    (unregister-fn
      ""
      [client-map f host]
      (dissoc-in client-map [host f])))

