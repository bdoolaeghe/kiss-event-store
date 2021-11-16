.PHONY: all build

all: db/up

all/clean:
	docker kill $$(docker ps -q)

db/up:
	docker-compose -f docker-compose.yml up -d

db/down:
	docker-compose down

db/log:
	docker-compose logs

db/reset: db/down db/up

db/psql:
	docker exec -ti pg_eventstore_sample bash -c "psql -U postgres"

