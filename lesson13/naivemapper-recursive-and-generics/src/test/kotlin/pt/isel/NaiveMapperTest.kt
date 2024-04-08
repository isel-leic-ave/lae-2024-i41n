package pt.isel

import org.junit.jupiter.api.Test
import kotlin.reflect.*
import kotlin.reflect.full.createType
import kotlin.reflect.full.memberProperties
import kotlin.test.assertEquals
import kotlin.test.assertFalse

class NaiveMapperTest {
    @Test
    fun mapArtistSpotifyToArtistVersion3() {
        val mapper = NaiveMapper.mapper(ArtistSpotify::class, Artist::class)
        val source = ArtistSpotify("Muse", Country("UK", "English"), listOf(
            Song("Resistance", 2010),
            Song("Hysteria", 2003)
        ))
        val dest:Artist = mapper.mapFrom(source)
        assertEquals(source.name, dest.name)
        assertEquals(source.country.name, dest.from.name)
        assertEquals(source.country.idiom, dest.from.idiom)
        val tracks = dest.tracks.iterator()
        source.songs.forEach {
            val actual = tracks.next()
            assertEquals(it.name, actual.name)
            assertEquals(it.year, actual.year)
        }
        assertFalse { tracks.hasNext() }

    }

    @org.junit.jupiter.api.Test
    fun genericsTest() {
        val l : List<Int> = listOf()


        val typeOf: KType = typeOf<ArtistSpotify>()

        ArtistSpotify::class.memberProperties.forEach {
            println("${it.name} - arguments = ${it.returnType.arguments.size}")
  }



        val prop: KProperty1<ArtistSpotify, *> = ArtistSpotify::class
            .memberProperties
            .first { it.returnType.classifier == List::class }

        val type: KType = prop.returnType.arguments[0].type!!
        println(type)
    }
}