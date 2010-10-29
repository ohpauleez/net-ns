(ns net-ns.client.core
  (:require [clojure.repl :as clj-repl]
            [clojure.string :as clj-str]))

(comment
  (net-ns
    (:register [some-func :to ["host1" "192.168.2.2" :as this-func]
                              ["host3"]
                              ["host4" :as some-function]])
    (:expose [:to ["host1]
                  ["host2" :only some-func]])
    (:require [some-other-func :as this-cool-func]
              [one-more-func :as omf :from "host1"])))
(comment (expose function & to-lists))

(defn registerfn-str
  ""
  ;([f & to-specs])
  [f ns-info & to-specs]
  (str "reg" (hash-map :to to-specs :ns ns-info) ": " (clj-repl/source f)))

; ns-map -> map of all the ns mappings
; ns-publics -> all public interns for the ns
; ns-interns -> all interns for the ns
; ns-resolve -> resolves the symbol the given namespace, nil if not resolved

(defn map-replace-str
  "Perform a bunch of replaces on a string, using a map {'match-word' 'new-word'"
  [s str-map]
  (reduce (fn [ss sub] (clj-str/replace ss (sub 0) (sub 1)) s (vec str-map))))

