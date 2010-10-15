(ns net-ns.server.mapper)

(defprotocol Mapper
  (register-client [m host])
  (register-client [m host init-set])
  (register-fn [m f host])
  (unregister-client [m host])
  (unregister-fn [m f host]))

