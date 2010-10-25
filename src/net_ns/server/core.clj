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
     - a vector of strings, [msg-type, options, f] ^net-ns-msg"
  [msg]
  {:pre [(instance? java.lang.String msg)]}
  (let [type-pos (.indexOf msg "{")
        pos (.lastIndexOf msg ":")
        msg-type (subs msg 0 type-pos)
        options (cljs/trim (subs msg type-pos pos))
        f (cljs/trim (subs msg (inc pos)))]
    (with-meta [msg-type options f] {:net-ns-msg true}))

(defn msg-as-map
  ""
  [msg-vec]
  {:pre [((meta msg-vec) :net-ns-msg)]}
  (zipmap [:msg-type :options :f] msg-vec))

