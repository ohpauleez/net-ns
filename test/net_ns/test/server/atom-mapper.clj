(ns net-ns.test.server.atom-mapper
  (:require [net-ns.server.atom-mapper :as atom-mapper] :reload)
  (:use  [clojure.test :only (deftest is)]
         [lazytest.describe :only (describe it testing)]))


(describe "Registering clients"
  (testing "with no existing function sets")
  (testing "with existing function sets")
  (testing "with existing function sets that aren't really sets"))

(describe "Registering functions"
  (testing "with a registered client")
  (testing "with a unregistered client"))

(describe "Unregistering clients"
  (testing "when the client is registered and has mapped functions")
  (testing "when the client is registered but has not mapped functions")
  (testing "when the client is not registered"))

(describe "Unregistering functions"
  (testing "when the client is registered, has registered functions including the one targeted for removal")
  (testing "when the client is registered, has registered functions, but not the target function")
  (testing "when the client is registered, but has no registered functions")
  (testing "when the client is not registered"))

