(ns jeotools.referencing.crs)

(defn create-geographic-crs
  "Given a name of a geographic CRS, create a GeographicCRS object."
  [code]
  (.createGeographicCRS (org.geotools.referencing.CRS/getAuthorityFactory false) code))
