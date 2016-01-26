(ns jeotools.styling)

(defn read-sld-file [url-path]
  (let [style-factory (org.geotools.factory.CommonFactoryFinder/getStyleFactory nil)
        sld-url (java.net.URL. url-path)
        sld-parser (org.geotools.styling.SLDParser. style-factory sld-url)
        style-from-file (first (vec (.readXML sld-parser)))]
    style-from-file))

(defn create-polygon-style [outline-color fill-color opacity]
  (org.geotools.styling.SLD/createPolygonStyle outline-color fill-color opacity))
