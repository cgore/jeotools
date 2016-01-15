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

(defn color
  "This function is intended to process *anything* that can reasonably be viewed
  as a color and return a java.awt.Color instance for it."
  ([rgb]
   (cond (integer? rgb)
         (Color. (int rgb))

         (instance? Color rgb)
         rgb

         (string? rgb)
         (Color/decode rgb)

         :else
         (Color. rgb)))
  ([rgba has-alpha]
   (Color. (int rgba) (boolean has-alpha)))
  ([r g b]
   (cond (every? integer? [r g b])
         (Color. (int r) (int g) (int b))

         (every? float? [r g b])
         (Color. (float r) (float g) (float b))

         :else
         (Color. r g b)))
  ([r g b a]
   (cond (every? integer? [r g b a])
         (Color. (int r) (int g) (int b) (int a))

         (every? float? [r g b a])
         (Color. (float r) (float g) (float b) (float a))

         :else
         (Color. r g b a))))

