package com.github.mather.sample.model

import org.joda.time.DateTime

case class TweetId(id: String)

class Message private (val text: String)

object Message {
  def create(text: String): Message = {
    val escaped = text
      .replaceAll("&", "&amp;")
      .replaceAll("\"", "&quot;")
      .replaceAll("'", "&#39")
      .replaceAll("<", "&lt;")
      .replaceAll(">", "&gt;")
    new Message(escaped)
  }
}

class Tweet(val id: TweetId,
            val author: Author,
            val message: Message,
            val createdAt: DateTime) {
  // TODO: implement methods
  def messageText: String = message.text
}

case class TweetList(list: Seq[Tweet])
