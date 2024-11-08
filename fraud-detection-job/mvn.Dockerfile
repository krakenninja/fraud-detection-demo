FROM flink:1.15-java8

COPY target/dynamic-fraud-detection-1.2-flink-1.15.1.jar lib/job.jar
COPY docker-entrypoint.sh /

USER flink
EXPOSE 8081 6123
ENTRYPOINT ["/docker-entrypoint.sh"]
