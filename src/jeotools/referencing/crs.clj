(ns jeotools.referencing.crs)

;;; org.geotools.referencing
;;; class CRS
;;; Javadocs: <http://docs.geotools.org/latest/javadocs/org/geotools/referencing/CRS.html>

(defn get-authority-factory
  "Returns the CRS authority factory used by the decode methods."
  ([]
   (get-authority-factory false))
  ([longitude-first?]
   (org.geotools.referencing.CRS/getAuthorityFactory longitude-first?)))

(defn create-crs
  "Returns an arbitrary coordinate reference system from a code."
  (.createCoordinateReferenceSystem (get-authority-factory) code))

(defn create-compound-crs
  "Creates a 3D coordinate reference system from a code."
  [code]
  (.createCompoundCRS (get-authority-factory) code))

(defn create-derived-crs
  "Creates a derived coordinate reference system from a code."
  [code]
  (.createDerivedCRS (get-authority-factory) code))

(defn create-engineering-crs
  "Creates an engineering coordinate reference system from a code."
  [code]
  (.createEngineeringCRS (get-authority-factory) code))

(defn create-geocentric-crs
  "Creates a geocentric coordinate reference system from a code."
  [code]
  (.createGeocentricCRS (get-authority-factory) code))

(defn create-geographic-crs
  "Returns a geographic coordinate reference system from a code."
  [code]
  (.createGeographicCRS (get-authority-factory) code))

(defn create-image-crs
  "Creates an image coordinate reference system from a code."
  [code]
  (.createImageCRS (get-authority-factory) code))

(defn create-projected-crs
  "Creates a projected coordinate reference system from a code."
  [code]
  (.createProjectedCRS (get-authority-factory) code))

(defn create-temporal-crs
  "Creates a temporal coordinate reference system from a code."
  [code]
  (.createTemporalCRS (get-authority-factory) code))

(defn create-vertical-crs
  "Creates a vertical coordinate reference system from a code."
  [code]
  (.createVerticalCRS (get-authority-factory) code))
