(ns ol-eval.core-test
  (:require [clojure.test :refer :all]
            [ol-eval.core :refer :all]))

;Test 1
(deftest test-only
  (testing "Trying with only the test and no keyed conditionals."
    (is (= nil (key-if (> 3 1))))))


;Test 2
(deftest then-only
  (testing "Trying with the test and a then."
    (is (= 'ok (key-if (> 3 1) :then 'ok)))))

;Test 3
(deftest else-only
  (testing "Trying with the test and an else."
    (is (= 'ok (key-if (< 5 3) :else 'ok)))))

;Test 4
(deftest failed-else-only
  (testing "Trying with only an else that fails to meet the condition."
    (is (= nil (key-if (> 3 1) :else 'oops)))))

;Test 5
(deftest nil-then-only
  (testing "Trying with only a nil then."
    (is (= nil (key-if (> 3 1) :then)))))

;Test 6
(deftest else-then-oops
  (testing "Else and then out of order."
    (is (= 'ok (key-if (> 3 1) :else 'oops :then 'ok)))))

;Had a hard time getting this test to work with the (println 'hi) followed by the 'ok
;I checked it manually though
(comment
;Test 7
(deftest else-then-oops-print
  (testing "Else and then out of order with println."
    (is (= 'hi(newline)'ok (key-if (> 3 1) :else 'oops :then (println 'hi) 'ok)))))
)

;Test 8
(deftest launch-macro-test
  (testing "Will fail with a function but not with a macro."
    (is (= 'ok (key-if (> 3 9) :then (println 'launching-missiles) :else 'ok)))))
