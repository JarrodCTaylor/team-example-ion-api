(ns team-example-ion-api.routes.example
    (:require
      [team-example-ion-api.queries :as query]
      [team-example-ion-api.middleware.inject-datomic :refer [inject-datomic-mw]])
    (:import [java.util UUID]))

(defn response [{{:keys [db]} :datomic
                 {:keys [id]} :path-params}]
      (let [the-count (query/get-specific-stuff-count db (UUID/fromString id))]
           {:status 200
            :body {:count the-count}}))

(def routes
  ["/stuff-count/{id}" {:middleware [inject-datomic-mw]
                        :get response}])