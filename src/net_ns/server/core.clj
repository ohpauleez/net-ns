(ns net-ns.server.core
  (:require [clojure.string :as cljs]))

(comment
  "reg{}: code-block"
  "reg{options}: code-block"
  "reg{options, :ns {nspublics}}: code-block")

(defn parse-msg
  "parse a message, splitting it into its canonical three parts: type, options, function
  Arguments:
    msg - a string, the message sent to the nameserver
  Returns:
     - a map of strings, keys [:msg-type, :options, :f] ^net-ns-msg"
  [msg]
  {:pre [(instance? java.lang.String msg)]}
  (let [type-pos (.indexOf msg "{")
        pos (.lastIndexOf msg ":")
        msg-type (subs msg 0 type-pos)
        options (cljs/trim (subs msg type-pos pos))
        f (cljs/trim (subs msg (inc pos)))]
    (with-meta {:msg-type msg-type, :options options, :f f} {:net-ns-msg true})))

