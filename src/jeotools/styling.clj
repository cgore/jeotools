(ns jeotools.styling
  (:require [jeotools.filter :refer [literal-expression]]))

(defn read-sld-file [url-path]
  (let [style-factory (org.geotools.factory.CommonFactoryFinder/getStyleFactory nil)
        sld-url (java.net.URL. url-path)
        sld-parser (org.geotools.styling.SLDParser. style-factory sld-url)
        style-from-file (first (vec (.readXML sld-parser)))]
    style-from-file))

(defn create-polygon-style [outline-color fill-color opacity]
  (org.geotools.styling.SLD/createPolygonStyle outline-color fill-color opacity))

(defn color-map-entry [{:keys [color quantity opacity]}]
  (doto (org.geotools.styling.ColorMapEntryImpl.)
    (.setColor (literal-expression color))
    (.setQuantity (literal-expression quantity))
    (.setOpacity (literal-expression opacity))))

(defn style-builder []
  (org.geotools.styling.StyleBuilder.))
