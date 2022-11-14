(ns team-example-ion-api.config)

(def region "us-east-1")
(def system "team-ion-example")

(def dev-arg-map {:system system
                  :server-type :dev-local})

(def datomic-arg-map {:server-type :ion
                      :region region
                      :system system
                      :endpoint "https://h9d5axjwa5.execute-api.us-east-1.amazonaws.com"})
