package com.github.mather.sample.model

case class AuthorId(id: String)

case class AuthorName(name: String)

case class Author(id: AuthorId, name: AuthorName) {
  def displayName: String = name.name
}
