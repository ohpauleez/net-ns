(ns net-ns.test.server.async
  (:require [net-ns.server.async :as async] :reload)
  (:use  [clojure.test :only (deftest is)]
         [lazytest.describe :only (describe it testing)]))

(deftest replace-measync ;; FIXME: write
  (is false "No tests have been written."))

(describe "Server Connection"
  (testing "on localhost"
    (it "Sits listening"
        (= 1 2))))
