package com.example.dddkotprac.catalog.domain.product

import com.example.dddkotprac.common.MoneyConverter
import com.example.dddkotprac.common.model.Money
import jakarta.persistence.*
import java.util.*


@Entity
@Table(name = "product")
class Product(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val name: String,
    @Convert(converter = MoneyConverter::class)
    val price: Money,
    @OneToMany(
        mappedBy = "product",
        cascade = [CascadeType.ALL],
        orphanRemoval = true)
    val images: MutableList<Image> = mutableListOf(),
    val detail: String,
) {

    fun changeImages(images: List<Image>) {
        deleteImages()
        images.forEach { image -> addImage(image)}
    }

    private fun addImage(image: Image) {
        if(Objects.isNull(image.product)) {
            image.product = this
        }
        images.add(image)
    }

    private fun deleteImages() {
        images.clear()
    }
}
