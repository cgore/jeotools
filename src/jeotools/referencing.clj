(ns jeotools.referencing)

(defn create-geographic-crs
  "Given a name of a geographic CRS, create a GeographicCRS object."
  [name]
  (.createGeographicCRS (org.geotools.referencing.CRS/getAuthorityFactory false) name))
