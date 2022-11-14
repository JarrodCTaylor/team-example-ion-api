(ns datomic-scratch
  (:require
    [clojure.edn :as edn]
    [clojure.string :as str]
    [clojure.java.io :as io]
    [datomic.client.api :as d]
    [clj-time.core :as t]
    [clj-time.coerce :as c]
    [team-example-ion-api.queries :as queries]
    [team-example-ion-api.config :refer [datomic-arg-map]]))

;*********************
;; DB Con, etc
;*********************
(def client (d/client datomic-arg-map))
; (d/create-database client {:db-name "team-example-ion-api-local"})
; (d/delete-database client {:db-name "team-example-ion-api-local"})
(def conn (d/connect client {:db-name "team-example-ion-api-local"}))
(def db (d/db conn))

;*********************
;; Load initial schema
;*********************
(def db-schema (-> "migrations/1_initial_schema.edn" io/resource slurp edn/read-string))
(d/transact conn {:tx-data db-schema})

;*********************
;; Load initial data
;*********************
(def db-data (-> "migrations/2_initial_data.edn" io/resource slurp edn/read-string))
(d/transact conn {:tx-data db-data})

;*********************
;; Query shit!
;*********************
(d/q '[:find ?amt-of-stuff
       :where [_ :stuff/count ?amt-of-stuff]
              [(> 100 ?amt-of-stuff)]] db)
