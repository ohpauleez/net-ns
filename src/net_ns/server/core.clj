(ns net-ns.server.core
  (:require [clojure.string :as cljs]))

(comment
  "reg{}: code-block"
  "reg{options}: code-block"
  "reg{options, :ns {nspublics}}: code-block")

(defn parse-msg
  ""
  [msg]
  (let [type-pos (.indexOf msg "{")
        pos (.lastIndexOf msg ":")
        msg-type (subs msg 0 type-pos)
        options (cljs/trim (subs msg type-pos pos))
        f (cljs/trim (subs msg (inc pos)))]
    [msg-type options f]))

