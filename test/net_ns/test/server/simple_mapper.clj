(ns net-ns.test.server.core
  (:require [net-ns.server.core :as core] :reload)
  (:use  [clojure.test :only (deftest is)]
         [lazytest.describe :only (describe it testing)]))

(deftest replace-mecore ;; FIXME: write
  (is false "No tests have been written."))

(describe "Registering clients"
  (testing "with no existing function sets")
  (testing "with existing function sets")
  (testing "with existing function sets that aren't really sets"))

(describe "Registering functions"
  (testing "with a registered client")
  (testing "with a unregistered client"))

