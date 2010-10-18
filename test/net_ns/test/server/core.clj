(ns net-ns.test.server.core
  (:require [net-ns.server.core :as s-core] :reload)
  (:use  [clojure.test :only (deftest is)]
         [lazytest.describe :only (describe it testing)]))

(describe "Parsing messages sent to the server"
  (testing "without options")
  (testing "with options, but no :ns options")
  (testing "with options and a form")
  (testing "without options and a form")
  (testing "with options and a value/string"))

