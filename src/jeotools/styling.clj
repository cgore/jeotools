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

(defn color-map [style-builder v]
  (let [entries (map color-map-entry v)
        result (org.geotools.styling.ColorMapImpl.)]
    (doall (map #(.addColorMapEntry result %) entries))
    result))

(defn color-map-style [v]
  (let [raster-symbolizer (fn [style-builder v]
                            (doto (org.geotools.styling.RasterSymbolizerImpl. (.getFilterFactory style-builder))
                              (.setColorMap (color-map style-builder v))))
        rule (fn [style-builder v]
               (.createRule style-builder (raster-symbolizer style-builder v)))
        feature-type-style (fn [style-builder v]
                             (.createFeatureTypeStyle style-builder nil (rule style-builder v)))
        style-builder (org.geotools.styling.StyleBuilder.)]
    (doto (.createStyle style-builder)
      (.addFeatureTypeStyle (feature-type-style style-builder v)))))
