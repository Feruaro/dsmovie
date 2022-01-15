import axios from "axios";
import MovieCard from "components/MovieCard";
import Pagination from "components/Pagination";
import { useEffect, useState } from "react";
import { MoviePage } from "types/movie";
import { BASE_URL } from "utils/requests";

function Listing() {

    //estado que guarda o número da página da requisição
    const [pageNumber, setPageNumber] = useState(0);     //0 -> valor inicial

    //estado que guarda a página da requisição
    const [page, setPage] = useState<MoviePage>({        //<> -> type do state
        content: [],
        last: true,
        totalPages: 0,
        totalElements: 0,
        size: 12,
        number: 0,
        first: true,
        numberOfElements: 0,
        empty: true
    })


    useEffect(() => {
        axios.get(`${BASE_URL}/movies?size=12&page=${pageNumber}&sort=id`)   //garantir que seja ordenado por "id"
                .then(response => {
                const data = response.data as MoviePage;
                setPage(data)
            })
    }, [pageNumber]);




    return (
        <>
            <Pagination />

            <div className="container">
                <div className="row">
                    {page.content.map(movie => (
                            <div key={movie.id} className="col-sm-6 col-lg-4 col-xl-3 mb-4">    
                                <MovieCard movie={movie} />
                            </div>
                        )
                    )}
                </div>
            </div>
        </>
    )
}

export default Listing;