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

                <input type="text" class="update-recordLabel" placeholder="New record label">                
                <button class="update-button">Update Tech Stack</button>
                <button class="delete-button">Delete</button>
            </div>
            `
        }) .join("")
    }

    </section>
    </main>
    `

}