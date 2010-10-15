(ns net-ns.server.core)


(def serve-map (atom {}))

(defn register-client!
  "Register a client as an endpoint, and optionally take
  and initial set of functions.  If init-set is not a 
  clojure.lang.PersistentHashSet, it is ignored.
  Arguments:
    host - a string, the hostname of the client
    [init-set] - a set of of strings, the names of functions
  Notes:
    THIS WILL MODIFY THE SERVE MAP"
  ([host]
   (swap! serve-map assoc host #{}))
  ([host init-set]
   (if (isa? (class init-set) clojure.lang.PersistentHashSet))
   (swap! serve-map assoc host init-set)
   (register-client host)))

(defn register-fn!
  "Register a function with a client.  If the client is not
  already in the serve-map, it is added with the function as
  its init-set.
  Arguments:
    f - a string, the name of the function to register
    host - a string, the hostname of the client
  Notes:
    THIS WILL MODIFY THE SERVE-MAP"
  [f host]
  (let [func-set (serve-map host)]
    (if (nil? func-set)
      (register-client host #{f})
      (swap! serve-map assoc host (conj (serve-map host) f)))))

;TODO unregister, purge

