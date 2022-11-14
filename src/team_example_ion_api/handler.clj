(ns team-example-ion-api.handler
    (:require
      [muuntaja.core :as m]
      [reitit.ring :as ring]
      [reitit.ring.middleware.muuntaja :as muuntaja]
      [ring.middleware.params :as params]
      [team-example-ion-api.middleware.cors :refer [cors-mw options-mw]]
      [team-example-ion-api.routes.example :as example]))

(def app
  (ring/ring-handler
    (ring/router
      ["/api/v1" [example/routes]]
      {:data {:muuntaja m/instance
              :middleware [options-mw
                           cors-mw
                           params/wrap-params
                           muuntaja/format-middleware]}})
    (ring/create-default-handler)))

(defn -main [& args]
      (println app)
      (println "This should pass the deploy check :)"))
