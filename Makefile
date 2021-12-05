build_db:
	docker build -t books-db infra/db/.

stop_db:
	docker container rm -f books-db || true

run_db:
	make stop_db
	make build_db
	docker run -d --name books-db -p 5433:5432 books-db