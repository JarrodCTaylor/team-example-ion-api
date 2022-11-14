(ns team-example-ion-api.db-conn
  (:require
    [datomic.ion :as ion]
    [datomic.client.api :as d]
    [team-example-ion-api.utils :as utils]
    [team-example-ion-api.config :refer [datomic-arg-map]]))

(def db-name (or (:db-name (ion/get-env)) "team-example-ion-api-local"))

(def client (memoize #(d/client datomic-arg-map)))

(defn db-conn []
      (utils/with-retry #(d/connect (client) {:db-name db-name})))