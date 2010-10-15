(ns ns-net.server.atom-mapper
  (:require [net-ns.server.mapper :as mapper])
  (:use [clojure.contrib.core :only (dissoc-in)]))

(extend-type clojure.lang.Atom
  mapper/Mapper
    (register-client
      "Register a client as an endpoint, and optionally take
      and initial set of functions.  If init-set is not a 
      clojure.lang.PersistentHashSet, it is ignored.
      Arguments:
        client-map - an atom of a map
        host - a string, the hostname of the client
        [init-set] - a set of of strings, the names of functions
      Returns:
        the map with the client added
      NOTE:
        THIS WILL MODIFY THE CLIENT-MAP"
      ([client-map host]
       (swap! client-map assoc host #{}))
      ([client-map host init-set]
       (if (isa? (class init-set) clojure.lang.PersistentHashSet)
         (swap! client-map assoc host init-set)
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
        the map with the updated function list for the client
      NOTE:
        THIS WILL MODIFY THE CLIENT-MAP"
      [client-map f host]
      (let [func-set (serve-map host)]
        (if (nil? func-set)
          (register-client client-map host #{f})
          (swap! client-map assoc host (conj (@client-map host) f)))))

    (unregister-client
      ""
      [client-map host]
      (swap! client-map dissoc host))

    (unregister-fn
      ""
      [client-map f host]
      (swap! client-map dissoc-in [host f])))

