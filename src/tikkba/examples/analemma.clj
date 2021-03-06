(ns tikkba.examples.analemma
  (:use [analemma svg charts xml]
        [tikkba swing dom])
  (:import (javax.swing JFrame SwingUtilities)))

(def analemma-data)

(defn analemma-svg
  "Creates a SVG representation with the Analemma functions"
  []
  (svg
   (apply group
          (-> (text "Analemma")
              (add-attrs :x 120 :y 60)
              (style :fill "#000066"
                     :font-family "Garamond"
                     :font-size "75px"
                     :alignment-baseline :middle))
          (for [[x y] analemma-data]
            (circle (translate-value x -30 5 0 125)
                    (translate-value y -25 30 125 0)
                    2 :fill "#000066")))))

(defn create-frame
  [canvas]
  (let [frame (JFrame.)]
    (.add (.getContentPane frame) canvas)
    (.setSize frame 800 200)
    (.setDefaultCloseOperation frame JFrame/EXIT_ON_CLOSE)
    (SwingUtilities/invokeAndWait
     (fn [] (.setVisible frame true)))))

(defn -main
  []
  ;; Converts the SVG representation to a XML Document
  ;; and displays the SVG in a JFrame
  (let [doc (svg-doc (analemma-svg))
        canvas (jsvgcanvas)]
    (set-document canvas doc)
    (create-frame canvas)))

(def analemma-data
     [[-15.165 -23.07]
      [-17.016 -22.70]
      [-19.171 -22.08]
      [-21.099 -21.27]
      [-22.755 -20.30]
      [-24.107 -19.16]
      [-25.446 -17.33]
      [-25.914 -16.17]
      [-26.198 -14.62]
      [-26.158 -12.96]
      [-25.814 -11.21]
      [-25.194 -9.39]
      [-24.520 -7.89]
      [-23.708 -6.37]
      [-22.529 -4.42]
      [-21.205 -2.45]
      [-19.777 -0.48]
      [-18.289 1.50]
      [-16.185 4.24]
      [-15.009 5.78]
      [-13.605 7.66]
      [-12.309 9.49]
      [-11.153 11.26]
      [-10.169 12.94]
      [-9.250 14.85]
      [-8.811 16.04]
      [-8.469 17.43]
      [-8.364 18.69]
      [-8.493 19.83]
      [-8.847 20.82]
      [-9.685 21.96]
      [-10.317 22.47]
      [-11.231 22.96]
      [-12.243 23.28]
      [-13.308 23.43]
      [-14.378 23.41]
      [-15.599 23.16]
      [-16.339 22.86]
      [-17.139 22.33]
      [-17.767 21.64]
      [-18.191 20.80]
      [-18.387 19.81]
      [-18.253 18.20]
      [-17.956 17.17]
      [-17.361 15.78]
      [-16.529 14.28]
      [-15.474 12.68]
      [-14.221 11.01]
      [-12.183 8.54]
      [-10.901 7.07]
      [-9.212 5.20]
      [-7.462 3.29]
      [-5.693 1.36]
      [-3.946 -0.59]
      [-1.938 -2.93]
      [-0.686 -4.48]
      [0.742 -6.39]
      [1.982 -8.28]
      [2.993 -10.11]
      [3.742 -11.88]
      [4.290 -14.23]
      [4.318 -15.49]
      [4.044 -16.97]
      [3.420 -18.33]
      [2.446 -19.55]
      [1.135 -20.63]
      [-0.852 -21.71]
      [-2.398 -22.29]
      [-4.538 -22.86]
      [-6.855 -23.24]
      [-9.286 -23.42]
      [-11.761 -23.41]
      [-14.691 -23.14]])