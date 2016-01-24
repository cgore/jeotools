(ns jeotools.geometry.jts)

;;; com.vividsolutions.jts.geom.Coordinate
;;; Javadocs: <http://tsusiatsoftware.net/jts/javadoc/com/vividsolutions/jts/geom/Coordinate.html>

(defn coordinate
  ([]
   (com.vividsolutions.jts.geom.Coordinate.))
  ([c]
   (com.vividsolutions.jts.geom.Coordinate. c))
  ([x y]
   (com.vividsolutions.jts.geom.Coordinate. x y))
  ([x y z]
   (com.vividsolutions.jts.geom.Coordinate. x y z)))

(defn coordinate-array [v]
  (into-array com.vividsolutions.jts.geom.Coordinate
              (map #(apply coordinate %) v)))

(defn coordinate-array-sequence [coordinates]
  (com.vividsolutions.jts.geom.impl.CoordinateArraySequence. coordinates))

;;; com.vividsolutions.jts.geom.GeometryFactory
;;; Javadocs: <http://tsusiatsoftware.net/jts/javadoc/com/vividsolutions/jts/geom/GeometryFactory.html>

(defn geometry-factory []
  (com.vividsolutions.jts.geom.GeometryFactory.))

;;; com.vividsolutions.jts.geom.LinearRing
;;; Javadocs: <http://tsusiatsoftware.net/jts/javadoc/com/vividsolutions/jts/geom/LinearRing.html>

(defn linear-ring [coordinates]
  (com.vividsolutions.jts.geom.LinearRing. coordinates (geometry-factory)))

;;; com.vividsolutions.jts.geom.Geometry
;;; Javadocs: <http://tsusiatsoftware.net/jts/javadoc/com/vividsolutions/jts/geom/Geometry.html>

;;; org.geotools.geometry.jts
;;; Javadocs: <http://docs.geotools.org/stable/javadocs/org/geotools/geometry/jts/JTS.html>
