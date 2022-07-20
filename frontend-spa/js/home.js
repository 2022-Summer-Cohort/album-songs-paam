export default function home(albums) {
    return`
    <main class="main-content">
    <section class="album-library">
        ${albums.map(album => {
            return `
            <div class="album">
                <h2 class="album-title">${album.title}</h2>
                <input type="hidden" class="id field" value="${album.id}">
                <h3 class="album-song">${album.songs}</h3>
            </div>
            `
        }) .join("")
    }

    </section>
    </main>
    `

}