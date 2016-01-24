(ns jeotools.referencing.crs)

;;; org.geotools.referencing
;;; class CRS
;;; Javasocs: <http://docs.geotools.org/latest/javadocs/org/geotools/referencing/CRS.html>

(defn create-geographic-crs
  "Given a name of a geographic CRS, create a GeographicCRS object."
  [code]
  (.createGeographicCRS (org.geotools.referencing.CRS/getAuthorityFactory false) code))
