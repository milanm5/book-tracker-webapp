import { Component, inject, Injectable } from '@angular/core';
import { SearchResultService } from '../../services/search-result.service';
import { SearchResult } from '../../model/search-result';
import { NgClass } from '@angular/common';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { Book } from '../../model/book';

@Component({
  selector: 'app-search-result',
  imports: [RouterLink, NgClass],
  templateUrl: './search-result.component.html',
  styleUrl: './search-result.component.css'
})

@Injectable({providedIn: "root"})
export class SearchResultComponent {

  private searchResultService = inject(SearchResultService);
  private route = inject(ActivatedRoute);
  router = inject(Router);
  searchResult!: SearchResult;
  searchQuery!: string;
  prevClasses!: {[key: string]: boolean}
  nextClasses!: {[key: string]: boolean}
  totalPages = 0;
  startPage = 0;
  endPage = 0;
  firstBtn = 1;
  secondBtn = 2;
  thirdBtn = 3;
  currentPage: number = 1;

  ngOnInit() {
    this.route.queryParams.subscribe(params => {
      this.currentPage = Number(params["page"]);
      this.searchQuery = params["q"];
      
      this.searchResultService.searchBooks(this.searchQuery, this.currentPage - 1).subscribe(
        result => {
          this.searchResult = result;
          
          this.prevClasses = {
            "disabled": this.currentPage == 1
          };
    
          this.nextClasses = {
            "disabled": this.currentPage == this.endPage 
          };
          this.setPages();
        });
    });
  }

  getCoverUrl(book: Book): string {
    const coverId = book.editions.docs.at(0)?.cover_i;
    return coverId ? "https://covers.openlibrary.org/b/id/" + coverId + "-M.jpg" : "images/no_cover_img.jpg";
  }

  previousPage() {
    this.router.navigate([], {
      relativeTo: this.route,
      queryParams: {page: this.currentPage - 1},
      queryParamsHandling: "merge"
    })
  }

  nextPage() {
    this.router.navigate([], {
      relativeTo: this.route,
      queryParams: {page: this.currentPage + 1},
      queryParamsHandling: "merge"
    })
  }

  setPages() {
    this.totalPages = Math.ceil(this.searchResult.numFound / 5);
    this.endPage = this.totalPages;
    this.secondBtn = this.currentPage;
    this.thirdBtn = Math.min(this.currentPage+1, this.endPage);
    this.firstBtn = Math.min(this.currentPage-1, this.startPage);
  }
}
