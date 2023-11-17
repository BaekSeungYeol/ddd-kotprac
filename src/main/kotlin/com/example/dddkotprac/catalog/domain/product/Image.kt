package com.example.dddkotprac.catalog.domain.product
import jakarta.persistence.*
import java.time.ZonedDateTime


@Entity
@Table(name = "image")
class Image(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    val id: Long,
    @Column(name = "image_path")
    val path: String,
    @Column(name = "upload_time")
    val uploadTime: ZonedDateTime,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    var product: Product? = null,
    @Enumerated(EnumType.STRING)
    val imageType: ImageType
) {

}