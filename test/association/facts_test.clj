(ns association.facts-test
  (:require [clojure.test :refer [deftest is]]
            [association.facts :as facts]))

(deftest tbb-has-spec-basis
  (let [sb (facts/spec-basis "tbb")]
    (is (= 2 (count sb)))
    (is (every? #(= "6419" (:association-rule/isic %)) sb))
    (is (every? #(= "TUR" (:association-rule/country %)) sb))))

(deftest unknown-association-has-no-spec-basis
  (is (nil? (facts/spec-basis "aeb")))
  (is (nil? (facts/spec-basis "zzz"))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["tbb" "aeb"])]
    (is (= 2 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["aeb"] (:missing-associations c)))))

(deftest by-topic-filters
  (is (= 1 (count (facts/by-topic "tbb" :governance))))
  (is (= 1 (count (facts/by-topic "tbb" :consumer-protection))))
  (is (empty? (facts/by-topic "tbb" :labor)))
  (is (empty? (facts/by-topic "aeb" :governance))))
