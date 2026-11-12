package com.example.controllers;

import com.example.dto.request.CreateNewsRequest;
import com.example.services.NewsService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("/news")
@Produces(MediaType.APPLICATION_JSON)
public class NewsController {

    @Inject NewsService newsService;

@POST
@Consumes(MediaType.APPLICATION_JSON)
public Response createNews(CreateNewsRequest req) {
    return Response.ok(newsService.create(req)).build();
}

    @GET
    public Response getPublished() {
        return Response.ok(newsService.getPublished()).build();
    }

    @GET @Path("/{id}")
    public Response getById(@PathParam("id") String id) {
        return Response.ok(newsService.getAdminById(id)).build();
    }
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") String id, CreateNewsRequest req) {
        return Response.ok(newsService.update(id, req)).build();
    }


    @DELETE
        @Path("/{id}")
        public Response delete(@PathParam("id") String id) {
            newsService.delete(id);
            return Response.ok().build(); // Trả về 200 OK sau khi xóa thành công
        }

}