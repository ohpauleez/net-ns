(ns net-ns.server.mapper)

(defprotocol Mapper
  (register-client [m host] [m host init-set]
    "Register a client as an endpoint, and optionally take
      and initial set of functions.  If init-set is not a 
      clojure.lang.PersistentHashSet, it is ignored.
      Arguments:
        m - a map, anything that supports APersistentMap (or a concurrent/mutative wrapped map)
        host - a string, the hostname of the client
        [init-set] - a set of of strings, the names of functions
      Returns:
        the map with the client added
      Notes:
        When using conncurrent/mutative types, M IS MODIFIED")
  (register-fn [m str-f host]
    "Register a function with a client.  If the client is not
      already in the serve-map, it is added with the function as
      its init-set.
      Arguments:
        m - a map, anything that supports APersistentMap (or a concurrent/mutative wrapped map)
        str-f - a string, the name of the function to register
        host - a string, the hostname of the client
      Returns:
        the map with the updated function list for the client
      Notes:
        When using conncurrent/mutative types, M IS MODIFIED")
  (unregister-client [m host]
    "Unregister a client as an endpoint.
      Arguments:
        m - a map, anything that supports APersistentMap (or a concurrent/mutative wrapped map)
        host - a string, the hostname of the client
      Returns:
        te map with the client removed
      Notes:
        When using concurrent/mutative types, M IS MODIFIED")
  (unregister-fn [m str-f host]
    "Unregister a function with a given client.  If client is not in the map,
      operation is no-op.
      Arguments:
        m - a map, anything that supports APersistentMap (or a concurrent/mutative wrapped map)
        str-f - a string, the name of the function to unregister
        host - a string, the hostname of the client
      Returns:
        the map with the client removed
      Notes:
        When using concurrent/mutative types, M IS MODIFIED"))

