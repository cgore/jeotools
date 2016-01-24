(ns jeotools.referencing.crs)

;;; org.geotools.referencing
;;; class CRS
;;; Javasocs: <http://docs.geotools.org/latest/javadocs/org/geotools/referencing/CRS.html>

(defn get-authority-factory
  "Returns the CRS authority factory used by the decode methods."
  ([]
   (get-authority-factory false))
  ([longitude-first?]
   (org.geotools.referencing.CRS/getAuthorityFactory longitude-first?)))

(defn create-geographic-crs
  "Given a name of a geographic CRS, create a GeographicCRS object."
  [code]
  (.createGeographicCRS (get-authority-factory) code))
