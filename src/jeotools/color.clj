(ns jeotools.color
  (:import [java.awt Color]))

(def awt-colors
  "This is a hash map of all of the predefined color constants from AWT.
  For example, awt-colors[:lightGray] will produce light gray."
  (let [awt-color-names (map :name (filter #(and (instance? clojure.reflect.Field %)
                                                 (= "java.awt.Color" (str (:type %))))
                                           (sequence (:members (clojure.reflect/reflect java.awt.Color)))))]
    (into {} (map #(hash-map (keyword %)
                             (eval (symbol (str "java.awt.Color/" %))))
                  awt-color-names))))
