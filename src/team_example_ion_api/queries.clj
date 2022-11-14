(ns team-example-ion-api.queries
  (:require
    [datomic.client.api :as d]))

(defn get-specific-stuff-count [db stuff-id]
  (-> (d/q '[:find ?count
             :in $ ?stuff-id
             :where [?stuff :stuff/id ?stuff-id]
                    [?stuff :stuff/count ?count]]
           db stuff-id)
      ffirst))
