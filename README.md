# team-example-ion-api

## Summary

- One api-gateway endpoint will serve the Reitit api app.

## Dev

### Local server

Start in the `local-server` namespace

### Deploy

Ensure you have a clean git status (no uncommited or unstashed changes).

``` sh
clj -A:dev -m datomic.ion.dev '{:op :push}'
```