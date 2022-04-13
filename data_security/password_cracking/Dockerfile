# A Debian distro with John the Ripper installed.
FROM debian:jessie

RUN apt-get update && apt-get install -y john vim

RUN adduser --disabled-password --gecos "" teste1
RUN adduser --disabled-password --gecos "" teste2
RUN adduser --disabled-password --gecos "" teste3

RUN echo "teste1:123" | chpasswd
RUN echo "teste2:abc" | chpasswd
RUN echo "teste3:Sh*#+ab15%" | chpasswd