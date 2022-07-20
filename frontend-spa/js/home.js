export default function home(albums) {
    return`
    <main class="main-content">
    <section class="album-library">
        ${albums.map(album => {
            return `
            <div class="album">
                <h2 class="album-title">${album.title}</h2>
                <input type="hidden" class="id field" value="${album.id}">
                <h3 class="album-song">Record Label: ${album.recordLabel}</h3>
                <img src=${album.imgUrl}>
                <p class = "album-rating">Ratings: ${album.ratings}</p>
            </div>
            `
        }) .join("")
    }

    </section>
    </main>
    `

}