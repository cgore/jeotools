(defproject jeotools "0.1.0-SNAPSHOT"
  :description "JeoTools = GeoTools + Clojure"
  :url "https://github.com/cgore/jeotools"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :profiles {:dev {:resource-paths ["test/resources"]}}
  :repositories {"osgeo" "http://download.osgeo.org/webdav/geotools"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.geotools/gt-main      "14.1"]
                 [org.geotools/gt-coverage  "14.1"]
                 [org.geotools/gt-epsg-wkt  "14.1"]
                 [org.geotools/gt-geojson   "14.1"]
                 [org.geotools/gt-geotiff   "14.1"]
                 [org.geotools/gt-image     "14.1"]
                 [org.geotools/gt-render    "14.1"]
                 [org.geotools/gt-shapefile "14.1"]
                 [org.geotools/gt-wms       "14.1"]])
