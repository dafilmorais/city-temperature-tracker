#!/bin/bash


# Run 'mvn package' in kafka-consumer directory
cd kafka-consumer
mvn package
cd ..

# Run 'mvn package' in kafka-producer directory
cd kafka-producer
mvn package
cd ..

producer_image_name="kafka/producer"
producer_image_tag="latest"
consumer_image_name="kafka/consumer"
consumer_image_tag="latest"

docker build -t $producer_image_name:$producer_image_tag -f kafka-producer/src/main/docker/Dockerfile.jvm kafka-producer

docker build -t $consumer_image_name:$consumer_image_tag -f kafka-consumer/src/main/docker/Dockerfile.jvm kafka-consumer

producer_tarball="kafka-producer.tar"
consumer_tarball="kafka-consumer.tar"

docker save -o $producer_tarball $producer_image_name:$producer_image_tag

docker save -o $consumer_tarball $consumer_image_name:$consumer_image_tag

docker load -i $producer_tarball

docker load -i $consumer_tarball

docker-compose up -d

