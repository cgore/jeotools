(ns jeotools.filter)

(defn literal-expression [value]
  (org.geotools.filter.LiteralExpressionImpl. value))
